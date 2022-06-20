import { ReactNode } from 'react';
import { CSSProp } from 'styled-components';

import * as S from './style';

export interface ButtonProps {
  children: ReactNode;
  onClick: () => void;
  disabled?: boolean;
  className?: string;
  customStyle?: CSSProp | null | undefined;
}

export function Button({
  children,
  onClick,
  disabled = false,
  className,
  customStyle,
}: ButtonProps) {
  return (
    <S.Button className={className} onClick={onClick} disabled={disabled} customStyle={customStyle}>
      {children}
    </S.Button>
  );
}

export function SecondaryButton({
  children,
  onClick,
  disabled = false,
  className,
  customStyle,
}: ButtonProps) {
  return (
    <S.Secondary
      className={className}
      onClick={onClick}
      disabled={disabled}
      customStyle={customStyle}
    >
      {children}
    </S.Secondary>
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
