import styled, { css } from 'styled-components';

export const Button = styled.button`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-radius: 20px;

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
`;
