import { rest } from 'msw';

import { mockIssueList, mockIssueDetail } from '@/mocks/issue/data';

const issueHandler = [
  rest.get('/issues', (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockIssueList));
  }),
  rest.get('/issues/:id', (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockIssueDetail));
  }),
];

export default issueHandler;
