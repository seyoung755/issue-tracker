import { Link } from 'react-router-dom';

import LoginForm from './LoginForm';
import * as S from './stlye';

export default function Login() {
  return (
    <div>
      <h1>ISSUE TRACKER</h1>
      <S.GithubLoginButton onClick={() => {}} disabled={false}>
        GitHub 계정으로 로그인
      </S.GithubLoginButton>
      <div>or</div>
      <LoginForm />
      <Link to="/signup">회원가입</Link>
    </div>
  );
}
