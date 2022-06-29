import { AxiosResponse } from 'axios';
import { useEffect } from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';

import authApi from '@/api/auth';
import { HOME_ROUTE, LOGIN_ROUTE } from '@/constant/route';
import { localStorageDB } from '@/utils/localstorage';

const CODE = 'code';

export default function Callback() {
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();
  const getToken = async () => {
    const code = searchParams.get(CODE);
    try {
      if (!code) return;
      const {
        data: { accessToken, refreshToken },
      } = await authApi.getGithubOAuthToken(code);
      localStorageDB.set('accessToken', accessToken);
      localStorageDB.set('refreshToken', refreshToken);
      navigate(HOME_ROUTE);
    } catch (error) {
      console.error(error);
      navigate(LOGIN_ROUTE);
    }
  };
  useEffect(() => {
    getToken();
  }, []);
  return <div>Callback</div>;
}
