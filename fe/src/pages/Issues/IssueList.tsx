import { useRecoilValue } from 'recoil';

import { issueListQuery } from '@/stores/selector/issueListQuery';

import * as S from './style';

export default function IssueList() {
  const issueList = useRecoilValue(issueListQuery);
  console.log('issueList :>> ', issueList);
  return <S.IssueTableCellList>IssueList</S.IssueTableCellList>;
}
