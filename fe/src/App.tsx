import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import PrivateRoute from '@/hoc/PrivateRoute';
import PublicRoute from '@/hoc/PublicRoute';
import { IssueDetail, Issues, Labels, Login, Milestones, NotFound, Signup } from '@/pages';

// TODO: isLogin이라는 util 메서드를 만들어서 로그인 여부를 boolean으로 반환하기
export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/issues" replace />} />
        <Route path="/login" element={<PublicRoute Component={Login} isLogin restricted />} />
        <Route path="/signup" element={<PublicRoute Component={Signup} isLogin restricted />} />
        <Route path="/issues" element={<PrivateRoute Component={Issues} isLogin />} />
        <Route path="/issues/:id" element={<PrivateRoute Component={IssueDetail} isLogin />} />
        <Route path="/labels" element={<PrivateRoute Component={Labels} isLogin />} />
        <Route path="/milestones" element={<PrivateRoute Component={Milestones} isLogin />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}
