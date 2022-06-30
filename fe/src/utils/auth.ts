import jwt_decode from 'jwt-decode';

import { localStorageDB } from '@/utils/localstorage';

export const isAccessTokenExpired = () => {
  const token = localStorageDB.get('accessToken');
  const now = new Date().getTime() / 1000;
  let isExpired = true; // 토큰이 없을 때는 만료되었다는 의미
  if (token) {
    const { exp } = jwt_decode<{ exp: string; id: string }>(token);
    isExpired = Number(exp) < now;
  }
  return isExpired;
};
