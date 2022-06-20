import styled from 'styled-components';

import Button, { ButtonProps } from '@/components/Common/Button';

export const LoginButton = styled(Button)<ButtonProps>`
  padding: 0px 24px;
  width: 340px;
  height: 64px;
`;

export const GithubLoginButton = styled(Button)<ButtonProps>`
  padding: 0px 24px;

  width: 340px;
  height: 64px;

  background: ${({ theme }) => theme.colors.greyscale.titleActive};
  border-radius: 20px;
  color: ${({ theme }) => theme.colors.greyscale.offWhite};
`;
