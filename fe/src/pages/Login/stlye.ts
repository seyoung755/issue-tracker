import styled from 'styled-components';

import Button, { ButtonProps } from '@/components/Common/Button';

export const LoginButton = styled(Button)<ButtonProps>`
  padding: 0px 24px;

  width: 340px;
  height: 64px;

  background: ${({ theme }) => theme.COLOR.BLUE[200]};
  border-radius: 20px;
  color: ${({ theme }) => theme.COLOR.WHITE};
`;

export const GithubLoginButton = styled(Button)<ButtonProps>`
  padding: 0px 24px;

  width: 340px;
  height: 64px;

  background: ${({ theme }) => theme.COLOR.BLACK};
  border-radius: 20px;
  color: ${({ theme }) => theme.COLOR.WHITE};
`;
