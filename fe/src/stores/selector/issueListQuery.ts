import { selector } from 'recoil';

import issueApi from '@/api/issue';
import { issueListState } from '@/stores/atoms/issue';
import { IssueListType } from '@/types/IssueType';

export const issueListQuery = selector<IssueListType>({
  key: 'issueListQuery',
  get: async ({ get }) => {
    const issueList = get(issueListState);
    // TODO: 반복되는 try, catch utils로 빼기
    try {
      const response = await issueApi.getIssueList();
      console.log('response', response);
      return issueList;
    } catch (error) {
      // TODO: 에러처리 로직 구체화하기 (error-boundary적용)
      throw error;
    }
  },
});
