import styled, { css, CSSProp } from 'styled-components';

const commonStyle = css`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  ${({ theme }) => theme.buttonSizes.large}
  ${({ theme }) => theme.fonts.linkMedium}
`;

export const Button = styled.button<{ customStyle: CSSProp | null | undefined }>`
  ${commonStyle}
  background: ${({ theme }) => theme.colors.primary.normal};
  color: ${({ theme }) => theme.colors.greyscale.offWhite};

  :hover {
    background: ${({ theme }) => theme.colors.primary.dark};
    & path {
      stroke: ${({ theme }) => theme.colors.primary.dark};
    }
  }
  :focus {
    border: 4px solid ${({ theme }) => theme.colors.primary.light};
    & path {
      stroke: ${({ theme }) => theme.colors.primary.light};
    }
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

export const Secondary = styled.button<{ customStyle: CSSProp | null | undefined }>`
  ${commonStyle}
  background: ${({ theme }) => theme.colors.greyscale.offWhite};
  color: ${({ theme }) => theme.colors.primary.normal};
  border: 2px solid ${({ theme }) => theme.colors.primary.normal};
  :hover {
    border: 2px solid ${({ theme }) => theme.colors.primary.dark};
    & path {
      stroke: ${({ theme }) => theme.colors.primary.dark};
    }
  }
  :focus {
    border: 4px solid ${({ theme }) => theme.colors.primary.light};
    & path {
      stroke: ${({ theme }) => theme.colors.primary.light};
    }
  }
  ${({ disabled, theme }) =>
    disabled &&
    css`
      background: ${theme.colors.primary.normal};
      border: 2px solid ${theme.colors.primary.normal};
      opacity: 0.5;
    `}
  /* 커스텀 스타일이 있다면 커스텀 스타일로 오버라이딩 */
  ${({ customStyle }) =>
    customStyle &&
    css`
      ${customStyle};
    `}
`;

export const TextButton = styled.button<{ customStyle: CSSProp | null | undefined }>`
  color: ${({ theme }) => theme.colors.greyscale.label};
  ${({ theme }) => theme.fonts.linkSmall};
  :hover {
    color: ${({ theme }) => theme.colors.greyscale.titleActive};
    & path {
      stroke: ${({ theme }) => theme.colors.greyscale.titleActive};
    }
  }
  :focus {
    color: ${({ theme }) => theme.colors.greyscale.body};
    & path {
      stroke: ${({ theme }) => theme.colors.greyscale.titleActive};
    }
  }
  ${({ disabled, theme }) =>
    disabled &&
    css`
      background: ${theme.colors.greyscale.body};
      opacity: 0.5;
    `}
  /* 커스텀 스타일이 있다면 커스텀 스타일로 오버라이딩 */
  ${({ customStyle }) =>
    customStyle &&
    css`
      ${customStyle};
    `}
`;
