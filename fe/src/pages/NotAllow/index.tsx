import { useNavigate } from 'react-router-dom';

export default function NotAllow({ warnMessage }: { warnMessage: string }) {
  const navigate = useNavigate();
  const backToMain = () => {
    navigate('/');
  };
  return (
    <div>
      NotAllow
      <h1>{warnMessage}</h1>
      <button onClick={backToMain}>홈으로 돌아가기</button>
    </div>
  );
}
