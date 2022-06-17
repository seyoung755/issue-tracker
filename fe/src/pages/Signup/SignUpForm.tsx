import useForm from '@/hooks/useForm';

export default function SignUpForm() {
  type Values = {
    nickname: string;
    id: string;
    password: string;
    passwordCheck: string;
  };
  const initialValues = {
    nickname: '',
    id: '',
    password: '',
    passwordCheck: '',
  };
  const onSubmit = async (values: Values) => {
    console.log(values);
  };
  const { values, isValid, handleChange, handleSubmit } = useForm<Values>({
    initialValues,
    onSubmit,
  });
  return (
    <form onSubmit={handleSubmit}>
      <label>
        <div>닉네임</div>
        <input
          name="nickname"
          value={values.nickname}
          minLength={4}
          maxLength={16}
          placeholder="닉네임"
          onChange={handleChange}
        />
      </label>
      <label>
        <div>아이디</div>
        <input
          name="id"
          value={values.id}
          minLength={4}
          maxLength={16}
          placeholder="아이디"
          onChange={handleChange}
        />
      </label>
      <label>
        <div>비밀번호</div>
        <input
          name="password"
          type="password"
          value={values.password}
          minLength={6}
          maxLength={12}
          placeholder="비밀번호"
          onChange={handleChange}
        />
      </label>

      <label>
        <div>비밀번호 확인</div>
        <input
          name="passwordCheck"
          type="password"
          value={values.passwordCheck}
          minLength={6}
          maxLength={12}
          placeholder="비밀번호 확인"
          onChange={handleChange}
        />
      </label>

      <label>
        <div>프로필 이미지</div>
        <input type="file" name="profileImage" accept="image/png, image/jpeg" />
      </label>
      <button disabled={!isValid}>회원가입</button>
    </form>
  );
}
