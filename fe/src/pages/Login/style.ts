import { css } from 'styled-components';

export const SmallButon = css`
  ${({ theme }) => theme.buttonSizes.small}
  ${({ theme }) => theme.fonts.linkXSmall}
`;

export const GithubLoginButton = css`
  background: ${({ theme }) => theme.colors.greyscale.titleActive};
  :hover {
    background: ${({ theme }) => theme.colors.greyscale.label};
  }
  :focus {
    border: 4px solid ${({ theme }) => theme.colors.greyscale.line};
  }
`;
