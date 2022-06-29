import { rest } from 'msw';

import { MILESTONE_API } from '@/constant/api';
import { mockMilestones } from '@/mocks/milestone/data';

const milestoneHandler = [
  rest.get(MILESTONE_API.MILESTONES, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockMilestones));
  }),
];

export default milestoneHandler;
