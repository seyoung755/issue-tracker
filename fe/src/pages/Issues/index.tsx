import { Suspense } from 'react';

import Loader from '@/components/Loader';

import IssueList from './IssueList';
import IssueTableHeader from './IssueTableHeader';
import * as S from './style';

export default function Issues() {
  return (
    <S.IssueTableContainer>
      <IssueTableHeader />
      <Suspense fallback={<Loader />}>
        <IssueList />
      </Suspense>
    </S.IssueTableContainer>
  );
}
