import styled, { css } from 'styled-components';

import { TextInputSizesTypes } from '@/styles/theme';

export const TextInput = styled.div<{ textInputSize: keyof TextInputSizesTypes; isError: boolean }>`
  display: flex;
  align-items: center;
  background-color: ${({ theme }) => theme.colors.greyscale.inputBackground};
  ${({ textInputSize, theme }) =>
    css`
      ${theme.textInputSizes[textInputSize]}
    `}
  &:focus-within {
    border: 1px solid ${({ theme }) => theme.colors.greyscale.titleActive};
    background-color: ${({ theme }) => theme.colors.greyscale.offWhite};
  }
  ${({ theme, isError }) =>
    isError &&
    css`
      border: 1px solid ${theme.colors.error.normal};
      background-color: ${theme.colors.error.light};
    `}
`;

export const InputWrapper = styled.div<{ textInputSize: string }>`
  display: flex;
  flex-direction: ${({ textInputSize }) => (textInputSize === 'small' ? 'row' : 'column')};
  margin: 0 24px;
`;

export const Label = styled.label`
  display: flex;
  align-items: center;
  width: 40px;

  font-weight: 500;
  font-size: 12px;
  line-height: 20px;

  color: ${({ theme }) => theme.colors.greyscale.label};
`;

export const Input = styled.input`
  width: 100%;
  font-weight: 400;
  font-size: 16px;
  line-height: 28px;

  color: ${({ theme }) => theme.colors.greyscale.titleActive};

  &:invalid {
    background-color: ${({ theme }) => theme.colors.error.normal};
  }
`;

export const Caption = styled.div<{ type: 'success' | 'error' }>`
  font-weight: 500;
  font-size: 12px;
  line-height: 20px;
  color: ${({ type, theme }) => theme.colors[type].normal};
`;
