import { Link, useNavigate } from 'react-router-dom';

import { Button } from '@/components/Common/Button';
import { LOADING_ROUTE } from '@/constant/route';

import LoginForm from './LoginForm';
import * as S from './style';

export default function Login() {
  const navigate = useNavigate();

  function handleGitHubOAuthClick() {
    navigate(LOADING_ROUTE);
  }

  return (
    <div>
      <h1>ISSUE TRACKER</h1>
      <Button onClick={handleGitHubOAuthClick} customStyle={S.GithubLoginButton}>
        GitHub 계정으로 로그인
      </Button>
      <div>or</div>
      <LoginForm />
      <Link to="/signup">회원가입</Link>
    </div>
  );
}
