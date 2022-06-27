import { Suspense } from 'react';
import { useRecoilValue } from 'recoil';

import PopUp from '@/components/Common/Popup';
import Loader from '@/components/Loader';
import usePopup from '@/hooks/usePopup';
import { issueListQuery } from '@/stores/selector/issueList';

import * as S from './style';

function IssueList() {
  const issueList = useRecoilValue(issueListQuery);
  console.log('issueList :>> ', issueList);
  return <div>IssueList</div>;
}

export default function Issues() {
  const [parent, isPopupOpen, openPopUp, handleModalClick] = usePopup(false);

  return (
    <>
      <S.PopUp ref={parent}>
        <button onClick={openPopUp}>1</button>
        <PopUp parentComponent={parent} isOpen={isPopupOpen} onClose={handleModalClick}>
          1
        </PopUp>
      </S.PopUp>
      <Suspense fallback={<Loader />}>
        <IssueList />
      </Suspense>
    </>
  );
}
