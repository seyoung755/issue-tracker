import styled, { css, CSSProp } from 'styled-components';

export const Button = styled.button<{ customStyle: CSSProp | null | undefined }>`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  ${({ theme }) => theme.buttonSizes.large}
  ${({ theme }) => theme.fonts.linkMedium}
  background: ${({ theme }) => theme.colors.primary.normal};
  color: ${({ theme }) => theme.colors.greyscale.offWhite};

  :hover {
    background: ${({ theme }) => theme.colors.primary.dark};
  }
  :focus {
    border: 4px solid ${({ theme }) => theme.colors.primary.light};
  }
  ${({ disabled, theme }) =>
    disabled &&
    css`
      background: ${theme.colors.primary.normal};
      opacity: 0.5;
    `}
  /* 커스텀 스타일이 있다면 커스텀 스타일로 오버라이딩 */
  ${({ customStyle }) =>
    customStyle &&
    css`
      ${customStyle};
    `}
`;
