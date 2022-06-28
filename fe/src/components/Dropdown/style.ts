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
