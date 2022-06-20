import { ReactNode } from 'react';
import { CSSProp } from 'styled-components';

import { OverridableProps } from '@/utils/type';

import * as S from './style';

export interface ButtonProps {
  children: ReactNode;
  onClick: () => void;
  isSecondary?: boolean;
  disabled?: boolean;
  className?: string;
  customStyle?: CSSProp | null | undefined;
}

export function Button({
  children,
  onClick,
  disabled = false,
  isSecondary = false,
  className,
  customStyle,
}: ButtonProps) {
  const Style = isSecondary ? S.Secondary : S.Button;
  return (
    <Style className={className} onClick={onClick} disabled={disabled} customStyle={customStyle}>
      {children}
    </Style>
  );
}

export function TextButton({
  children,
  onClick,
  disabled = false,
  className,
  customStyle,
}: ButtonProps) {
  return (
    <S.TextButton
      className={className}
      onClick={onClick}
      disabled={disabled}
      customStyle={customStyle}
    >
      {children}
    </S.TextButton>
  );
}
