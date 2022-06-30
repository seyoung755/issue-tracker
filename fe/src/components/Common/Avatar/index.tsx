import { CSSProp } from 'styled-components';

import { IconSizeTypes } from '@/styles/theme';

import * as S from './style';

interface AvatarProps {
  profileImg: string;
  customStyle?: CSSProp;
  avatarSize?: keyof IconSizeTypes;
}

export default function Avatar({ profileImg, customStyle, avatarSize = 'base' }: AvatarProps) {
  return (
    <S.AvatarImg src={profileImg} alt="avatar" customStyle={customStyle} avatarSize={avatarSize} />
  );
}
