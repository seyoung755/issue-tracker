import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import { IssueDetail, Issues, Labels, Login, Milestones, NotFound, Signup } from '@/pages';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/issues" replace />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/issues" element={<Issues />} />
        <Route path="/issues/:id" element={<IssueDetail />} />
        <Route path="/labels" element={<Labels />} />
        <Route path="/milestones" element={<Milestones />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}
