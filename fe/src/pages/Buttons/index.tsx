import Button from '@/components/Common/Button';
import { GithubLoginButton, LoginButton } from '@/pages/Login/style';

export default function Buttons() {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: '12px', height: '100vh' }}>
      <Button onClick={() => {}}>일반 버튼</Button>
      <Button onClick={() => {}} customStyle={GithubLoginButton}>
        GitHub 계정으로 로그인
      </Button>
      <Button onClick={() => {}} customStyle={LoginButton}>
        아이디로 로그인
      </Button>
    </div>
  );
}
