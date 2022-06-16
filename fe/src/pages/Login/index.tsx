import { Link } from 'react-router-dom';

import LoginForm from '@/components/LoginForm';

export default function Login() {
  return (
    <div>
      <h1>ISSUE TRACKER</h1>
      <button>GitHub 계정으로 로그인</button>
      <div>or</div>
      <LoginForm />
      <Link to="/signup">회원가입</Link>
    </div>
  );
}
