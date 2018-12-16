defmodule Day01 do
  def final_frequency(file_stream) do
    file_stream
    |> Stream.map(fn line -> 
        {integer, _leftover} = Integer.parse(line)
        integer
      end)
    |> Enum.sum()
  end
end


case System.argv() do
  ["--test"] -> 
    ExUnit.start()

  defmodule Day01Test do
    use ExUnit.Case
    
    import Day01

    test "final frequency" do
      {:ok, io} = StringIO.open("""
+1
+1
+1
""")
      assert final_frequency(IO.stream(io, :line)) == 3
    end
  end

[input_file] -> 
  input_file
  |> File.stream!([], :line)
  |> Day01.final_frequency()
  |> IO.puts

_ ->
  IO.puts :stderr, "Expected --test or input file"
  System.halt(1)
end