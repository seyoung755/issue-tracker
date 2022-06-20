import { css } from 'styled-components';

export const LoginButton = css`
  padding: 0px 24px;
  width: 340px;
  height: 64px;
`;

export const GithubLoginButton = css`
  padding: 0px 24px;

  width: 340px;
  height: 64px;
  border-radius: 20px;

  background: ${({ theme }) => theme.colors.greyscale.titleActive};
  :hover {
    background: ${({ theme }) => theme.colors.greyscale.label};
  }
  :focus {
    border: 4px solid ${({ theme }) => theme.colors.greyscale.line};
  }
`;
