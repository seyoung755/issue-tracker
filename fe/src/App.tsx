import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import {
  HOME_ROUTE,
  ISSUES_DETAIL_ROUTE,
  ISSUES_ROUTE,
  LABELS_ROUTE,
  LOGIN_ROUTE,
  MILESTONES_ROUTE,
  SIGNUP_ROUTE,
  LOADING_ROUTE,
} from '@/constant/route';
import PrivateRoute from '@/hoc/PrivateRoute';
import PublicRoute from '@/hoc/PublicRoute';
import {
  Buttons,
  Icons,
  IssueDetail,
  Issues,
  Labels,
  Loading,
  Login,
  Milestones,
  NotFound,
  Signup,
  TextInputs,
} from '@/pages';

// TODO: isLogin이라는 util 메서드를 만들어서 로그인 여부를 boolean으로 반환하기
export default function App() {
  const isLogin = false;
  return (
    <BrowserRouter>
      <Routes>
        <Route path={HOME_ROUTE} element={<Navigate to={ISSUES_ROUTE} replace />} />
        <Route path="/buttons" element={<Buttons />} />
        <Route path="/icons" element={<Icons />} />
        <Route path="/textInputs" element={<TextInputs />} />

        <Route
          path={LOGIN_ROUTE}
          element={<PublicRoute Component={Login} isLogin={isLogin} restricted />}
        />
        <Route
          path={SIGNUP_ROUTE}
          element={<PublicRoute Component={Signup} isLogin={isLogin} restricted />}
        />
        <Route
          path={ISSUES_ROUTE}
          element={<PrivateRoute Component={Issues} isLogin={isLogin} />}
        />
        <Route
          path={ISSUES_DETAIL_ROUTE}
          element={<PrivateRoute Component={IssueDetail} isLogin={isLogin} />}
        />
        <Route
          path={LABELS_ROUTE}
          element={<PrivateRoute Component={Labels} isLogin={isLogin} />}
        />
        <Route
          path={MILESTONES_ROUTE}
          element={<PrivateRoute Component={Milestones} isLogin={isLogin} />}
        />
        <Route
          path={LOADING_ROUTE}
          element={<PublicRoute Component={Loading} isLogin={isLogin} restricted={false} />}
        />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}
