import { rest } from 'msw';

import { API_PREFIX, ISSUE_API } from '@/constant/api';
import { mockIssueList, mockIssueDetail } from '@/mocks/issue/data';

const issueHandler = [
  rest.get(API_PREFIX + ISSUE_API.ISSUES, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockIssueList));
  }),
  rest.get(`${API_PREFIX}/${ISSUE_API.ISSUES}/:id`, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockIssueDetail));
  }),
];

export default issueHandler;
