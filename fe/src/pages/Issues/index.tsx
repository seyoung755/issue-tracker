import { Suspense } from 'react';
import { useRecoilValue } from 'recoil';

import Loader from '@/components/Loader';
import { issueListQuery } from '@/stores/selector/issueList';

function IssueList() {
  const issueList = useRecoilValue(issueListQuery);
  console.log('issueList :>> ', issueList);
  return <div>IssueList</div>;
}

export default function Issues() {
  return (
    <Suspense fallback={<Loader />}>
      <IssueList />
    </Suspense>
  );
}
