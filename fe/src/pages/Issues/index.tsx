import styled from 'styled-components';

import Button, { ButtonProps } from '@/components/Common/Button';

export default function Issues() {
  return (
    <div>
      Issues
      <GithubLoginButton onClick={() => {}} disabled={false}>
        gihub로 로그인
      </GithubLoginButton>
      <NormalLoginButton onClick={() => {}} disabled={false}>
        id로 로그인
      </NormalLoginButton>
    </div>
  );
}

// FIXME: UI 예시를 위한 코드입니다.
const GithubLoginButton = styled(Button)<ButtonProps>`
  padding: 0px 24px;

  width: 340px;
  height: 64px;

  background: ${({ theme }) => theme.COLOR.BLACK};
  border-radius: 20px;
  color: ${({ theme }) => theme.COLOR.WHITE};
`;

const NormalLoginButton = styled(Button)<ButtonProps>`
  padding: 0px 24px;

  width: 340px;
  height: 64px;

  background: ${({ theme }) => theme.COLOR.BLUE[200]};
  border-radius: 20px;
  color: ${({ theme }) => theme.COLOR.WHITE};
`;
