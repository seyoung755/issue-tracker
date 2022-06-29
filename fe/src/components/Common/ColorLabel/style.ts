import styled, { css, CSSProp } from 'styled-components';

import { IconSizeTypes } from '@/styles/theme';

export const ColorLabel = styled.div<{
  backgroundColor: string;
  fontColor?: string;
  customStyle?: CSSProp;
  size: keyof IconSizeTypes;
}>`
  background-color: ${({ backgroundColor }) => backgroundColor};
  color: ${({ fontColor, theme }) => fontColor || theme.colors.greyscale.background};
  border-radius: 50%;
  border: 1px solid ${({ theme }) => theme.colors.greyscale.line};
  ${({ size, theme }) =>
    css`
      ${theme.iconSizes[size]}
    `}
  ${({ customStyle }) =>
    customStyle &&
    css`
      ${customStyle};
    `};
`;
