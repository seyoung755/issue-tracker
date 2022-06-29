import styled from 'styled-components';

export const Dropdown = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 1px;

  position: absolute;
  width: 240px;
  height: 183px;
  top: 66px;

  background: ${({ theme }) => theme.colors.greyscale.line};
  border: 1px solid ${({ theme }) => theme.colors.greyscale.line};
  border-radius: 16px;
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
