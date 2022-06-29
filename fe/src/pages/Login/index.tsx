import { Link } from 'react-router-dom';

import authApi from '@/api/auth';
import { Button } from '@/components/Common/Button';

import LoginForm from './LoginForm';
import * as S from './style';

export default function Login() {
  const handleGitHubOAuthClick = async () => {
    try {
      const response = await authApi.getGithubOAuthUrl();
      if (response.data) {
        // TODO: data 형식 체크하는 로직 구현
        window.location.href = response.data;
      }
    } catch (error) {
      console.error(error);
    }
  };

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
