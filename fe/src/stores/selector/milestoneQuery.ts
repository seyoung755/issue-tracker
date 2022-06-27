import { selector } from 'recoil';

import milestoneApi from '@/api/milestone';
import { milestoneListState } from '@/stores/atoms/milestoneList';
import { MilestoneListType } from '@/types/milestoneType';

export const MileStoneQuery = selector<MilestoneListType>({
  key: 'MileStoneQuery',
  get: async ({ get }) => {
    const milestoneList = get(milestoneListState);
    // TODO: 반복되는 try, catch utils로 빼기
    try {
      const response = await milestoneApi.getMileStones();
      console.log('response', response);
      return milestoneList;
    } catch (error) {
      // TODO: 에러처리 로직 구체화하기 (error-boundary적용)
      throw error;
    }
  },
});
