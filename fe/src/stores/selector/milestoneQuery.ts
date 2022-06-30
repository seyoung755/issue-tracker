import { selector } from 'recoil';

import milestoneApi from '@/api/milestone';
import { mockMilestones } from '@/mocks/milestone/data';
import { milestoneListState } from '@/stores/atoms/milestone';
import { MilestoneType } from '@/types/milestoneType';

export const mileStoneQuery = selector<MilestoneType[]>({
  key: 'mileStoneQuery',
  get: async ({ get }) => {
    const milestoneList = get(milestoneListState);
    // TODO: 반복되는 try, catch utils로 빼기
    try {
      const response = await milestoneApi.getMileStones();
      console.log('response', response);
      // return response.data.milestones;
      return mockMilestones;
    } catch (error) {
      // TODO: 에러처리 로직 구체화하기 (error-boundary적용)
      console.error(error);
      return [];
    }
  },
});
