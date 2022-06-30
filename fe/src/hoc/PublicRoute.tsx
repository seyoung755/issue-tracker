import { ComponentType } from 'react';

import { REFRESH_TOKEN } from '@/constant/token';
import { NotAllow } from '@/pages';
import { isTokenExpired } from '@/utils/auth';

interface PublicRouteProps {
  Component: ComponentType;
  restricted: boolean;
}

// restricted = false  => public route
// restricted = true => 로그인한 유저는 못들어감 (회원가입 페이지, 로그인 페이지)
export default function PublicRoute({ Component, restricted }: PublicRouteProps) {
  const isLogin = !isTokenExpired(REFRESH_TOKEN);

  return isLogin && restricted ? (
    <NotAllow
      warnMessage="로그인한 유저는 접근할 수 없다."
      fallbackButtonMessage={'홈으로 이동'}
      fallbackPath={'/'}
    />
  ) : (
    <Component />
  );
}
