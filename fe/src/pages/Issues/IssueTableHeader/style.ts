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

export const DropdownHeader = styled.h3`
  /* Title */

  /* Auto layout */
  display: flex;
  flex-direction: row;
  align-items: center;
  padding: 8px 16px;
  gap: 8px;

  width: 240px;
  height: 48px;

  /* Greyscale / Background */
  background-color: ${({ theme }) => theme.colors.greyscale.background};
  ${({ theme }) => theme.fonts.textMedium};
  border-radius: 16px 16px 0px 0px;
`;

export const DropdownBody = styled.ul`
  > li {
    /* Middle */

    /* Auto layout */
    display: flex;
    flex-direction: row;
    align-items: center;
    padding: 8px 16px;
    gap: 8px;

    width: 240px;
    height: 44px;

    background-color: ${({ theme }) => theme.colors.greyscale.offWhite};
    border-top: 1px solid ${({ theme }) => theme.colors.greyscale.line};
  }
  > li:last-child {
    border-radius: 0px 0px 16px 16px;
  }
`;
