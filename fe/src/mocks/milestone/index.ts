import { rest } from 'msw';

import { mockMilestones } from '@/mocks/milestone/data';

const milestoneHandler = [
  rest.get('/milestone', (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockMilestones));
  }),
];

export default milestoneHandler;
