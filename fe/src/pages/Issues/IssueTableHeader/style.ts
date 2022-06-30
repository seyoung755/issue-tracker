import styled, { css } from 'styled-components';

export const IssueTableHeader = styled.div`
  /* IssueTable / Header */

  width: 1280px;
  height: 64px;

  /* Greyscale / Background */
  background: #f7f7fc;
  border-radius: 16px 16px 0px 0px;

  /* Inside auto layout */
  flex: none;
  order: 0;
  flex-grow: 0;
`;

export const DropdownTextButtonContainer = styled.div`
  display: flex;
`;

export const DropdownTextButton = css`
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 8px;
  position: relative;
`;
