import useForm from '@/hooks/useForm';

export default function SignUpForm() {
  const onSubmit = async (values: { [key: string]: string }) => {
    console.log(values);
  };
  const { register, values, errors, handleSubmit } = useForm();
  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <label>
        <div>닉네임</div>
        <input name="nickname" {...register('nickname', { minLength: 4, maxLength: 10 })} />
        {errors.nickname?.minLength && <span>4자 이상 입력해주세요</span>}
        {errors.nickname?.maxLength && <span>10자 이하로 입력해주세요</span>}
      </label>
      <label>
        <div>아이디</div>
        <input name="id" {...register('id', { minLength: 4, maxLength: 16 })} />
        {errors.id?.minLength && <span>4자 이상 입력해주세요</span>}
        {errors.id?.maxLength && <span>16자 이하로 입력해주세요</span>}
      </label>
      <label>
        <div>비밀번호</div>
        <input
          name="password"
          type="password"
          {...register('password', { minLength: 6, maxLength: 10 })}
        />
        {errors.password?.minLength && <span>6자 이상 입력해주세요</span>}
        {errors.password?.maxLength && <span>16자 이하로 입력해주세요</span>}
      </label>

      <label>
        <div>비밀번호 확인</div>
        <input
          name="passwordCheck"
          type="password"
          {...register('passwordCheck', { pattern: new RegExp(`^${values.password}$`) })}
        />
        {errors.passwordCheck?.pattern && <span>비밀번호와 일치하지 않습니다.</span>}
      </label>

      <label>
        <div>프로필 이미지</div>
        <input type="file" name="profileImage" accept="image/png, image/jpeg" />
      </label>
      <button disabled={false}>회원가입</button>
    </form>
  );
}
