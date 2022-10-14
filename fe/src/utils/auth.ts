import jwt_decode from 'jwt-decode';

import { TokenTypes } from '@/constant/token';
import { localStorageDB } from '@/utils/localstorage';

export const isTokenExpired = (key: TokenTypes) => {
  const token = localStorageDB.get(key);
  const now = new Date().getTime() / 1000;
  let isExpired = true; // 토큰이 없을 때는 만료되었다는 의미
  try {
    if (token) {
      const { exp } = jwt_decode<{ exp: string; id: string }>(token);
      isExpired = Number(exp) < now;
    }
  } catch (error) {
    console.error(error);
  } finally {
    return isExpired;
  }
};
