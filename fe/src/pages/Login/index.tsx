import { Link } from 'react-router-dom';

import { Button } from '@/components/Common/Button';

import LoginForm from './LoginForm';
import * as S from './style';

export default function Login() {
  return (
    <div>
      <h1>ISSUE TRACKER</h1>
      <Button onClick={() => {}} customStyle={S.GithubLoginButton}>
        GitHub 계정으로 로그인
      </Button>
      <div>or</div>
      <LoginForm />
      <Link to="/signup">회원가입</Link>
    </div>
  );
}
