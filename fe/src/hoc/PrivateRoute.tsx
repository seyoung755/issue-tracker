import { ComponentType } from 'react';

import { NotAllow } from '@/pages';
import { isAccessTokenExpired } from '@/utils/auth';

interface PrivateRouteProps {
  Component: ComponentType;
}

// isLogin ? 로그인한 유저만 접근 가능 : 로그인하지 않은 유저는 접근할 수 없다.
export default function PrivateRoute({ Component }: PrivateRouteProps) {
  const isLogin = !isAccessTokenExpired();
  return isLogin ? (
    <Component />
  ) : (
    <NotAllow
      warnMessage="로그인하지 않은 유저는 접근할 수 없다."
      fallbackButtonMessage={'로그인 페이지로 이동'}
      fallbackPath={'/login'}
    />
  );
}
