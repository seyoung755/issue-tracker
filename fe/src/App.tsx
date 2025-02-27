import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import {
  HOME_ROUTE,
  ISSUES_DETAIL_ROUTE,
  ISSUES_ROUTE,
  LABELS_ROUTE,
  LOGIN_ROUTE,
  MILESTONES_ROUTE,
  SIGNUP_ROUTE,
  CALLBACK_ROUTE,
} from '@/constant/route';
import PrivateRoute from '@/hoc/PrivateRoute';
import PublicRoute from '@/hoc/PublicRoute';
import {
  Buttons,
  Icons,
  IssueDetail,
  Issues,
  Labels,
  Callback,
  Login,
  Milestones,
  NotFound,
  Signup,
  TextInputs,
} from '@/pages';

// TODO: isLogin이라는 util 메서드를 만들어서 로그인 여부를 boolean으로 반환하기
export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path={HOME_ROUTE} element={<Navigate to={ISSUES_ROUTE} replace />} />
        <Route path="/buttons" element={<Buttons />} />
        <Route path="/icons" element={<Icons />} />
        <Route path="/textInputs" element={<TextInputs />} />

        <Route path={LOGIN_ROUTE} element={<PublicRoute Component={Login} restricted />} />
        <Route path={SIGNUP_ROUTE} element={<PublicRoute Component={Signup} restricted />} />
        <Route path={ISSUES_ROUTE} element={<PrivateRoute Component={Issues} />} />
        <Route path={ISSUES_DETAIL_ROUTE} element={<PrivateRoute Component={IssueDetail} />} />
        <Route path={LABELS_ROUTE} element={<PrivateRoute Component={Labels} />} />
        <Route path={MILESTONES_ROUTE} element={<PrivateRoute Component={Milestones} />} />
        <Route
          path={CALLBACK_ROUTE}
          element={<PublicRoute Component={Callback} restricted={false} />}
        />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}
