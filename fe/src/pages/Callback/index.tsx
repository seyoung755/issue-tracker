import { useEffect } from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';

import authApi from '@/api/auth';
import { HOME_ROUTE, LOGIN_ROUTE } from '@/constant/route';

const CODE = 'code';

export default function Callback() {
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();
  const getToken = async () => {
    const code = searchParams.get(CODE);
    try {
      if (!code) return;
      const response = await authApi.getGithubOAuthToken(code);
      console.log(response);
      // navigate(HOME_ROUTE);
    } catch (error) {
      console.error(error);
      // navigate(LOGIN_ROUTE);
    }
  };
  useEffect(() => {
    getToken();
  }, []);
  return <div>Callback</div>;
}
