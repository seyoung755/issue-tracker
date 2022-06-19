import { useNavigate } from 'react-router-dom';

interface NotAllowProps {
  warnMessage: string;
  fallbackButtonMessage: string;
  fallbackPath: string;
}

export default function NotAllow({
  warnMessage,
  fallbackButtonMessage,
  fallbackPath,
}: NotAllowProps) {
  const navigate = useNavigate();
  const OnClickFallbackButton = () => {
    navigate(fallbackPath);
  };
  return (
    <div>
      NotAllow
      <h1>{warnMessage}</h1>
      <button onClick={OnClickFallbackButton}>{fallbackButtonMessage}</button>
    </div>
  );
}
