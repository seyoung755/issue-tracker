import { Icons, IconsType } from '@/assets/icons';
import { IconSizeTypes } from '@/styles/theme';

import * as S from './style';

export interface IconPropsType {
  iconName: IconsType;
  iconSize: keyof IconSizeTypes;
}

const Icon = ({ iconName, iconSize }: IconPropsType) => {
  return <S.Icon src={Icons[iconName]} size={iconSize} alt={iconName} />;
};

export default Icon;
