import styled, { css } from 'styled-components';

export const IssueTableContainer = styled.div`
  /* IssueTable / Initial */

  /* Auto layout */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 0px;
  gap: 1px;

  position: absolute;
  width: 1280px;
  height: 266px;
  left: 80px;
  top: 190px;

  /* Greyscale / Line */
  background: #d9dbe9;
  /* Greyscale / Line */
  border: 1px solid #d9dbe9;
  border-radius: 16px;
`;

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

export const IssueTableCellList = styled.ul``;
