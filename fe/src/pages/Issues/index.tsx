import { Suspense } from 'react';
import { useRecoilValue } from 'recoil';

import Dropdown from '@/components/Common/Dropdown';
import Loader from '@/components/Loader';
import useDropdown from '@/hooks/useDropdown';
import { issueListQuery } from '@/stores/selector/issueList';

import * as S from './style';

function IssueList() {
  const issueList = useRecoilValue(issueListQuery);
  console.log('issueList :>> ', issueList);
  return <div>IssueList</div>;
}

export default function Issues() {
  const [parent, isDropdownOpen, openDropdown, handleDropdownClick] = useDropdown(false);

  return (
    <>
      <S.PopUp ref={parent}>
        <button onClick={openDropdown}>1</button>
        <Dropdown parentComponent={parent} isOpen={isDropdownOpen} onClose={handleDropdownClick}>
          1
        </Dropdown>
      </S.PopUp>
      <Suspense fallback={<Loader />}>
        <IssueList />
      </Suspense>
    </>
  );
}
