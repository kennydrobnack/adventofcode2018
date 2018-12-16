defmodule Day01 do
  def final_frequency(input) do
    input
    |> String.split("\n", trim: true)
    |> sum_lines(0)
  end

  defp sum_lines([line | lines], current_frequency) do
  #TODO: why is this trim needed? We're getting " +1" instead of "+1" as expected with the previous trim: true
    new_frequency = String.to_integer(String.trim(line)) + current_frequency
    sum_lines(lines, new_frequency)
  end

  defp sum_lines([], current_frequency) do
    current_frequency
  end
end

ExUnit.start()

defmodule Day01Test do
  use ExUnit.Case

  import Day01

  test "final frequency" do
    assert final_frequency("""
      +1
      +1
      +1
    """) == 3
  end
end