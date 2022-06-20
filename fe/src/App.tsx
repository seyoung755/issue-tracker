import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import PrivateRoute from '@/hoc/PrivateRoute';
import PublicRoute from '@/hoc/PublicRoute';
import { Buttons, IssueDetail, Issues, Labels, Login, Milestones, NotFound, Signup } from '@/pages';

// TODO: isLogin이라는 util 메서드를 만들어서 로그인 여부를 boolean으로 반환하기
export default function App() {
  const isLogin = false;
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/issues" replace />} />
        <Route path="/buttons" element={<Buttons />} />
        <Route
          path="/login"
          element={<PublicRoute Component={Login} isLogin={isLogin} restricted />}
        />
        <Route
          path="/signup"
          element={<PublicRoute Component={Signup} isLogin={isLogin} restricted />}
        />
        <Route path="/issues" element={<PrivateRoute Component={Issues} isLogin={isLogin} />} />
        <Route
          path="/issues/:id"
          element={<PrivateRoute Component={IssueDetail} isLogin={isLogin} />}
        />
        <Route path="/labels" element={<PrivateRoute Component={Labels} isLogin={isLogin} />} />
        <Route
          path="/milestones"
          element={<PrivateRoute Component={Milestones} isLogin={isLogin} />}
        />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}
