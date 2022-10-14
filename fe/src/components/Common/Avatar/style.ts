import styled, { css, CSSProp } from 'styled-components';

import { IconSizeTypes } from '@/styles/theme';

export const AvatarImg = styled.img<{ customStyle?: CSSProp; avatarSize: keyof IconSizeTypes }>`
  border-radius: 50%;
  border: 1px solid ${({ theme }) => theme.colors.greyscale.line};
  ${({ avatarSize, theme }) =>
    css`
      ${theme.iconSizes[avatarSize]}
    `}
  ${({ customStyle }) =>
    customStyle &&
    css`
      ${customStyle};
    `};
`;
